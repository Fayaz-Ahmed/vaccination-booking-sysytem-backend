package com.example.demo.service.impl;

import com.example.demo.entity.MRoles;
import com.example.demo.entity.Moh;
import com.example.demo.entity.Roles;
import com.example.demo.entity.User;
import com.example.demo.exceptions.ChartVException;
import com.example.demo.exceptions.ChartVPersistenceException;
import com.example.demo.messages.ResponseMessages;
import com.example.demo.repository.MohRepository;
import com.example.demo.repository.RolesRepository;
import com.example.demo.request.dto.MohRequest;
import com.example.demo.request.dto.UserRequest;
import com.example.demo.response.dto.MohDto;
import com.example.demo.response.dto.UserDto;
import com.example.demo.response.template.Response;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import com.example.demo.service.util.DtoToEntityMapper;
import com.example.demo.service.util.EntityToDtoMapper;
import com.example.demo.util.EmailUtil;
import com.example.demo.util.JwtUtil;
import com.example.demo.validator.UserValidation;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MohRepository mohRepository;

    @Autowired
    private UserValidation userValidation;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private EntityToDtoMapper entityToDtoMapper;

    @Autowired
    private DtoToEntityMapper dtoToEntityMapper;

    @Autowired
    private EmailUtil emailUtil;
    @Autowired
    private RolesRepository roleRepo;

    @Override
    public ResponseEntity<Response<UserDto>> saveUser(UserRequest userRequest) throws ChartVException {

        try {
            userValidation.validateUser(userRequest.getUsername());
            userValidation.validateUserEmail(userRequest.getEmail());
            userValidation.validateUserNic(userRequest.getNic());

            Random r = new Random();
            String password = String.format("%06d", r.nextInt(100001));


            User user = userRepository.save(dtoToEntityMapper.convertToUser(userRequest, password));
            UserDto userDTO = entityToDtoMapper.convertUserDto(user);

            emailUtil.sendEmail(
                    userRequest.getEmail(),
                    "Login Credencials \n",
                    "Please find your login credencials here \n" +
                            "username :" + userRequest.getUsername() + "\n" +
                            "password :" + password);


            return Response.success(userDTO, HttpStatus.CREATED);

        } catch (ChartVException e) {
            throw e;
        } catch (Exception e) {

            if (e instanceof org.springframework.dao.DataIntegrityViolationException
                    && e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {

                org.hibernate.exception.ConstraintViolationException hibernateException = (ConstraintViolationException) e
                        .getCause();

                throw new ChartVPersistenceException(hibernateException.getCause().getLocalizedMessage(),
                        hibernateException.getCause());

            }
            System.out.println(e);
            throw new ChartVException(ResponseMessages.UNEXPECTED_ERROR, e.getCause());
        }
    }

    @Override
    public ResponseEntity<Response<MohDto>> saveMoh(MohRequest mohRequest) throws ChartVException {

        try {
            userValidation.validateMoh(mohRequest.getUsername());
            userValidation.validateMohEmail(mohRequest.getEmail());
            userValidation.validateMohNic(mohRequest.getNic());

            Random r = new Random();
            String password = String.format("%06d", r.nextInt(100001));

            emailUtil.sendEmail(
                    mohRequest.getEmail(),
                    "Login Credencials \n",
                    "Please find your login credencials here \n" +
                            "username :" + mohRequest.getUsername() + "\n" +
                            "password :" + password);


            Moh moh = mohRepository.save(dtoToEntityMapper.convertToMoh(mohRequest, password));
            MohDto mohDTO = entityToDtoMapper.convertMohDto(moh);
//            Set<Roles> roles = new HashSet<Roles>();
//            Roles ROLEMOH = roleRepo.findByName(MRoles.ROLE_MOH).get();
//            roles.add(ROLEMOH);
//            moh.setRoles(roles);


            return Response.success(mohDTO, HttpStatus.CREATED);

        } catch (ChartVException e) {
            throw e;
        } catch (Exception e) {

            if (e instanceof org.springframework.dao.DataIntegrityViolationException
                    && e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {

                org.hibernate.exception.ConstraintViolationException hibernateException = (ConstraintViolationException) e
                        .getCause();

                throw new ChartVPersistenceException(hibernateException.getCause().getLocalizedMessage(),
                        hibernateException.getCause());

            }

            throw new ChartVException(ResponseMessages.UNEXPECTED_ERROR, e.getCause());
        }
    }

}
