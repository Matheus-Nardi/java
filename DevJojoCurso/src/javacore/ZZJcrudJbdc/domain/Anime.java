package javacore.ZZJcrudJbdc.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Anime {
	private Integer id;
	private String name;
	private Integer episodes;
	private Producer producer;
}
