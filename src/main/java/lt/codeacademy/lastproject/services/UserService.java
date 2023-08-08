package lt.codeacademy.lastproject.services;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.lastproject.converters.UserConverter;
import lt.codeacademy.lastproject.dto.UserDTO;
import lt.codeacademy.lastproject.entities.UserEntity;
import lt.codeacademy.lastproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;


    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = userConverter.toEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        return userConverter.toDto(userEntity);
    }

    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(userConverter::toDto)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        return userConverter.toDto(userRepository.findById(id).orElse(null));
    }

    public UserDTO updateUserById(Long id, UserDTO userDTO) {
        UserEntity existingUser = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User with ID " + id + " not found"));

        existingUser.setUsername(userDTO.getUsername());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setAge(userDTO.getAge());
        existingUser.setHeight(userDTO.getHeight());
        existingUser.setWeight(userDTO.getWeight());

        UserEntity updatedUser = userRepository.save(existingUser);
        return userConverter.toDto(updatedUser);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
