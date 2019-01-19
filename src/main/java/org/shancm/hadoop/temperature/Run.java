package org.shancm.hadoop.temperature;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author shancm
 * @package org.shancm.hadoop.temperature
 * @description:
 * @date 2018/8/22
 */
public class Run {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		Job job = Job.getInstance();
		job.setJarByClass(Run.class);
		job.setJobName("max temperature");

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.setMapperClass(MapDemo.class);
		job.setReducerClass(ReduceDemo.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		System.out.println(job.waitForCompletion(true) ? 0 : 1);

	}
}
