package org.shancm.hadoop.mapreduce;

import org.apache.hadoop.io.Text;

/**
 * @author shancm
 * @package org.shancm.hadoop.mapreduce
 * @description:
 * @date 2018/10/26
 */
public class NcdcRecordParse {

	private String year;
	private int airTemplature;
	private String quality;

	public void parse(String record){
		year = record.substring(15, 19);
		if(record.charAt(87) == '+'){
			airTemplature = Integer.parseInt(record.substring(88, 92));
		}else {
			airTemplature = Integer.parseInt(record.substring(87, 92));
		}
		quality = record.substring(92, 93);
	}

	public void parse(Text text){
		parse(text.toString());
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getAirTemplature() {
		return airTemplature;
	}

	public void setAirTemplature(int airTemplature) {
		this.airTemplature = airTemplature;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}
}
