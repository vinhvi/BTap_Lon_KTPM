package com.example.userService.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String passWord;

    private String gioiTinh;
    private String email;


}
