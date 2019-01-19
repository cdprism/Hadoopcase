package org.shancm.hadoop.temperature;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author shancm
 * @package org.shancm.hadoop.temperature
 * @description:
 * @date 2018/8/22
 */
public class MapDemo extends Mapper<LongWritable, Text, Text, IntWritable> {

	public static final int MISSING = 9999;


	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//		super.map(key, value, context);

		String line = value.toString();
		String year = line.substring(15, 19);
		int temperature;
		if(line.charAt(87) == '+'){
			temperature = Integer.parseInt(line.substring(88, 92));
		}else {
			temperature = Integer.parseInt(line.substring(87, 92));
		}

		String quality = line.substring(92, 93);
		if(temperature!=MISSING && quality.matches("[01459]")){
			context.write(new Text(year), new IntWritable(temperature));
		}

	}
}
