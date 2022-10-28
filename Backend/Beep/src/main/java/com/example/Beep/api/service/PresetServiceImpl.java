package com.example.Beep.api.service;

import com.example.Beep.api.domain.dto.PresetRequestDto;
import com.example.Beep.api.domain.dto.PresetResponseDto;
import com.example.Beep.api.domain.entity.Authority;
import com.example.Beep.api.domain.entity.Preset;
import com.example.Beep.api.domain.entity.User;
import com.example.Beep.api.repository.PresetRepository;
import com.example.Beep.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class PresetServiceImpl implements PresetService{


    @Autowired
    PresetRepository presetRepository;

    @Autowired
    UserRepository userRepository;

    public void PresetSave(PresetRequestDto presetRequestDto) {
        try{
            Preset now=presetRepository.findPreset(presetRequestDto.getNumber().longValue(),presetRequestDto.getUid().longValue()).get();
            now.update(presetRequestDto.getNumber(), presetRequestDto.getContent());
            presetRepository.save(now);
        }catch (NoSuchElementException n){
            Preset preset= Preset.builder()
                    .user(userRepository.findById(presetRequestDto.getUid()).get())
                    .number(presetRequestDto.getNumber())
                    .part(presetRequestDto.getPart())
                    .content(presetRequestDto.getContent())
                    .build();
            presetRepository.save(preset);
        }
    }


    public void PresetDelete(Long id) {
        presetRepository.deleteById(id);
    }

    @Override
    public List<PresetResponseDto> PresetFind(Long id) {
        try {
            User user = userRepository.findById(id).get();
            if(user.getAuthority().equals(Authority.ROLE_LEAVE)){
                return null;
            }
            List<PresetResponseDto> presetResponseDtoList = user.getPresetList().stream()
                    .map(Preset -> PresetResponseDto.builder()
                            .uid(id)
                            .number(Preset.getNumber())
                            .part(Preset.getPart())
                            .content(Preset.getContent())
                            .build()).collect(Collectors.toList());
            return presetResponseDtoList;
        }catch (NoSuchElementException n){
            System.out.println("없는 유저 입니다");
        }
        return null;
    }
}
