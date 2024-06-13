package javacore.ZZIjdbc.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Builder
public final class Producer {
	private Integer id;
	private String name;
}
