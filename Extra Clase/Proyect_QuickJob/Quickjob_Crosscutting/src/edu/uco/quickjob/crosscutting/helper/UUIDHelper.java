package edu.uco.quickjob.crosscutting.helper;

import java.util.UUID;

import static edu.uco.quickjob.crosscutting.helper.ObjectHelper.getDefaultIfNull;

public final class UUIDHelper {
	
	private static final String DEFAULT_UUID_AS_STRING  = "00000000-0000-0000-0000-000000000000";
	private static final UUID DEFAULT_UUID = UUID.fromString(DEFAULT_UUID_AS_STRING);
	
	private UUIDHelper() {
		super();
	}
	
	public static final UUID getDefaultUUID(final UUID value){
		return getDefaultIfNull(value, DEFAULT_UUID);
	}
	
	public static final UUID getNewUUID() {
		return UUID.randomUUID();
	}
	
	public static final String getUUIDAsString (final UUID value) {
		return getDefaultUUID(value).toString();
	}
	
	public static final boolean isDefaultUUID(final UUID value) {
		return DEFAULT_UUID.equals(value);
	}

}
