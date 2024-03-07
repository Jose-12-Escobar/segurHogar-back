package com.daw.segurhogar.entities;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditEntity {

	@CreatedDate
	@Column(name = "FECHA_REGISTRO", updatable = false)
	private LocalDateTime createdDate;

	@LastModifiedDate
	@Column(name = "FECHA_MODIFICACION")
	private LocalDateTime modifiedDate;

}
