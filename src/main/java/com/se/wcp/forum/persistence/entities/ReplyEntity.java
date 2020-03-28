package com.se.wcp.forum.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@Entity(name = "replies")
public class ReplyEntity extends BaseEntity {

}
