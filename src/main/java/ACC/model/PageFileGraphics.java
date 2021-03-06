package ACC.model;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.Application;

public class PageFileGraphics implements Page {
	
	public	PageFileGraphics(SPageFileGraphics o){
		this.o = o;
		fillFieldsHelper(o);
	}
	
	@JsonIgnore
	private Object o;

	public int packetId = 0;
	public int status = 0;
	public int session = AC_SESSION_TYPE.AC_PRACTICE;
	public String currentTime = "";
	public String lastTime = "";
	public String bestTime = "";
	public String split = "";
	public int completedLaps = 0;
	public int position = 0;
	public int iCurrentTime = 0;
	public int iLastTime = 0;
	public int iBestTime = 0;
	public float sessionTimeLeft = 0;
	public float distanceTraveled = 0;
	public int isInPit = 0;
	public int currentSectorIndex = 0;
	public int lastSectorTime = 0;
	public int numberOfLaps = 0;
	public String tyreCompound;
	public float replayTimeMultiplier = 0;
	public float normalizedCarPosition = 0;

	public int activeCars = 0;
	public float[][] carCoordinates = new float[60][3];
	public int[] carID = new int[60];
	public int playerCarID = 0;
	public float penaltyTime = 0;
	public int flag = AC_FLAG_TYPE.AC_NO_FLAG;
	public int penalty = AC_PENALTYSHOTCUT.None;
	public int idealLineOn = 0;
	public int isInPitLane = 0;

	public float surfaceGrip = 0;
	public int mandatoryPitDone = 0;

	public float windSpeed = 0;
	public float windDirection = 0;

	public int isSetupMenuVisible = 0;

	public int mainDisplayIndex = 0;
	public int secondaryDisplayIndex = 0;
	public int TC = 0;
	public int TCCut = 0;
	public int EngineMap = 0;
	public int ABS = 0;
	public int fuelXLap = 0;
	public int rainLights = 0;
	public int flashingLights = 0;
	public int lightsStage = 0;
	public float exhaustTemperature = 0.0f;
	public int wiperLV = 0;
	public int DriverStintTotalTimeLeft = 0;
	public int DriverStintTimeLeft = 0;
	public int rainTyres = 0;
	
	@Override
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		String response = "";
		try {
			response = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			Application.LOGGER.debug(e.toString());
		}
		return response;
	}
	
	public void fillFieldsHelper(Object source) {
		List<Field> sourceFields = Arrays.asList(source.getClass().getDeclaredFields());
		sourceFields.forEach(valueOne -> {
			try {
				Object value = valueOne.get(source);
				Field attrOne = source.getClass().getDeclaredField(valueOne.getName().replace("source",""));
				switch (attrOne.getType().getName()) {
				 case "[F":
					 attrOne = source.getClass().getDeclaredField(valueOne.getName().replace("source",""));
					 int i = 0;
					 if (valueOne.getName().equals("carCoordinates")) {
						 float[] carccords = (float[])value;
						 for (int car = 0; car <=59; car++) {
							 for(int coords = 0; coords <=2; coords++) {
								 this.carCoordinates[car][coords] = carccords[i];
								 i++;
							 }
						 }
					 }
				     break;
				 case "[B":
					 attrOne = this.getClass().getDeclaredField(valueOne.getName().replace("source",""));
					 byte[] byteArr = (byte[])value;
					 attrOne.set(this, new String(byteArr,Charset.forName("UTF-16le")).replaceAll("\\u0000", "") );
				  break;
				 default: 
					 attrOne = this.getClass().getDeclaredField(valueOne.getName().replace("source",""));
					 attrOne.set(this, value);
					 break;
				}
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
			
		});
		
	}
}

