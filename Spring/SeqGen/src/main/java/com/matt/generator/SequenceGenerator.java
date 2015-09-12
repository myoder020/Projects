package com.matt.generator;

import gen.*;

public class SequenceGenerator {
	private String prefix;
	private String suffix;
	private int initial;
	private int counter;
	private PrefixGenerator prefixGenerator;
	
	public SequenceGenerator() {
		
	}
	
	public SequenceGenerator(String prefix, String suffix, int initial) {
		this.prefix = prefix;
		this.suffix = suffix;
		this.initial = initial;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}
	
	public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
		this.prefixGenerator = prefixGenerator;
	}

	public synchronized String getSequence() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(prefixGenerator.getPrefix());
		buffer.append(initial + counter++);
		buffer.append(suffix);
		return buffer.toString();
	}
}
