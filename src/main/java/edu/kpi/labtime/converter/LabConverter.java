package edu.kpi.labtime.converter;

import edu.kpi.labtime.dto.Lab;
import edu.kpi.labtime.dto.Remainder;
import edu.kpi.labtime.entity.LabEntity;
import edu.kpi.labtime.entity.RemainderEntity;

import java.util.List;
import java.util.stream.Collectors;

public class LabConverter {

    public static LabEntity convertFromDto(Lab dto){
        LabEntity lab = new LabEntity();
        lab.setSubject(dto.getSubject());
        lab.setNumber(dto.getNumber());
        lab.setTask(dto.getTask());
        lab.setDescription(dto.getDescription());
        lab.setRequirements(dto.getRequirements());
        return lab;
    }

    public static Lab convertFromEntity(LabEntity entity){
        Lab lab = new Lab();
        lab.setSubject(entity.getSubject());
        lab.setNumber(entity.getNumber());
        lab.setTask(entity.getTask());
        lab.setDescription(entity.getDescription());
        lab.setRequirements(entity.getRequirements());
        List<Remainder> remainders = RemainderConverter.convertConsistentToListDto(entity.getRemainders());
        lab.setRemainders(remainders.stream()
                .peek(remainder -> remainder.setLab(lab))
                .collect(Collectors.toList()));
        return lab;
    }

    public static List<Lab> convertToListDto(List<LabEntity> users){
        return users.stream()
                .map(LabConverter::convertFromEntity)
                .collect(Collectors.toList());
    }

    public static List<LabEntity> convertToListEntity(List<Lab> users){
        return users.stream()
                .map(LabConverter::convertFromDto)
                .collect(Collectors.toList());
    }
}
