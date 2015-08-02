package org.DDMAL.jMei2Midi.exception.handler;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ErrorResource {
	private String message;
}
