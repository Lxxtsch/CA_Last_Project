package lt.codeacademy.lastproject.converters;


import lt.codeacademy.lastproject.dto.UserDTO;
import lt.codeacademy.lastproject.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity toEntity(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAge(dto.getAge());
        entity.setHeight(dto.getHeight());
        entity.setWeight(dto.getWeight());
        return entity;
    }

    public UserDTO toDto(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setAge(entity.getAge());
        dto.setHeight(entity.getHeight());
        dto.setWeight(entity.getWeight());
        return dto;
    }
}