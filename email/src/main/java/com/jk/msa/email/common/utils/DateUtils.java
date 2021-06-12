package com.jk.msa.email.common.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class DateUtils {
	public static long localDateTimeToLongTimestamp(LocalDateTime time) {
		return Timestamp.valueOf(time).getTime();
	}

	public static LocalDateTime longTimestampToLocalDateTime(long timestamp) {
		return LocalDateTime.ofInstant(
			Instant.ofEpochMilli(timestamp),
			TimeZone.getDefault().toZoneId()
		);
	}
	
}

