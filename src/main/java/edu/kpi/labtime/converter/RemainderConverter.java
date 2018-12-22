package edu.kpi.labtime.converter;

import edu.kpi.labtime.dto.Remainder;
import edu.kpi.labtime.entity.RemainderEntity;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemainderConverter {

    public static RemainderEntity convertFromDto(Remainder dto){
        RemainderEntity remainder = new RemainderEntity();
        remainder.setTimeStart(dto.getTimeStart());
        remainder.setTimeEnd(dto.getTimeEnd());
        remainder.setRemainderMsg(dto.getRemainderMsg());
        remainder.setLab(LabConverter.convertFromDto(dto.getLab()));
        return remainder;
    }

    public static RemainderEntity convertConsistentFromDto(Remainder dto){
        RemainderEntity remainder = new RemainderEntity();
        remainder.setTimeStart(dto.getTimeStart());
        remainder.setTimeEnd(dto.getTimeEnd());
        remainder.setRemainderMsg(dto.getRemainderMsg());
        remainder.setLab(null);
        return remainder;
    }

    public static Remainder convertConsistentFromEntity(RemainderEntity entity){
        Remainder dto = new Remainder(entity.getTimeStart(),
                entity.getTimeEnd(),
                entity.getRemainderMsg(),
                null);
        return dto;
    }

    public static Remainder convertFromEntity(RemainderEntity entity){
        Remainder dto = new Remainder(entity.getTimeStart(),
                entity.getTimeEnd(),
                entity.getRemainderMsg(),
                LabConverter.convertFromEntity(entity.getLab()));
        return dto;
    }

    public static List<Remainder> convertToListDto(List<RemainderEntity> users){
        return users.stream()
                .map(RemainderConverter::convertFromEntity)
                .collect(Collectors.toList());
    }

    public static List<Remainder> convertConsistentToListDto(List<RemainderEntity> users){
        return users.stream()
                .map(RemainderConverter::convertConsistentFromEntity)
                .collect(Collectors.toList());
    }

    public static List<RemainderEntity> convertToListEntity(List<Remainder> users){
        return users.stream()
                .map(RemainderConverter::convertFromDto)
                .collect(Collectors.toList());
    }

    public static List<RemainderEntity> convertConsistentToListEntity(List<Remainder> users){
        return users.stream()
                .map(RemainderConverter::convertConsistentFromDto)
                .collect(Collectors.toList());
    }
}
