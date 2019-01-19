package org.shancm.hadoop.mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author shancm
 * @package org.shancm.hadoop.mapreduce
 * @description:
 * @date 2018/10/26
 */
public class MaxTemperatureMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	private NcdcRecordParse ncdcRecordParse = new NcdcRecordParse();

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		ncdcRecordParse.parse(value);

		context.write(new Text(ncdcRecordParse.getYear()), new IntWritable(ncdcRecordParse.getAirTemplature()));
	}



}
