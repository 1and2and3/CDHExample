package com.mfniu.example.mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<Object, Text, Text, IntWritable> {

	private Text word = new Text();

	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

		String line = value.toString();

		StringTokenizer tokenizer = new StringTokenizer(line);

		while (tokenizer.hasMoreTokens()) {

			word.set(tokenizer.nextToken());

			context.write(word, new IntWritable(1));

		}
	}
}
