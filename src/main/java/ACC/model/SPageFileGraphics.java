package ACC.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
import app.Application;



public class SPageFileGraphics extends Structure {

	public SPageFileGraphics(Pointer p) {
		super(p);
		read();
	}
	
	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList(
				"packetId"
               ,"status"
               ,"session"
               ,"currentTime"
               ,"lastTime"
               ,"bestTime"
               ,"split"
               ,"completedLaps"
               ,"position"
               ,"iCurrentTime"
               ,"iLastTime"
               ,"iBestTime"
               ,"sessionTimeLeft"
               ,"distanceTraveled"
               ,"isInPit"
               ,"currentSectorIndex"
               ,"lastSectorTime"
               ,"numberOfLaps"
               ,"tyreCompound"
               ,"replayTimeMultiplier"
               ,"normalizedCarPosition"
               ,"activeCars"
               ,"carCoordinates"
               ,"carID"
               ,"playerCarID"
               ,"penaltyTime"
               ,"flag"
               ,"penalty"
               ,"idealLineOn"
               ,"isInPitLane"
               ,"surfaceGrip"
               ,"mandatoryPitDone"
               ,"windSpeed"
               ,"windDirection"
               ,"isSetupMenuVisible"
               ,"mainDisplayIndex"
               ,"secondaryDisplayIndex"
               ,"TC"
               ,"TCCut"
               ,"EngineMap"
               ,"ABS"
               ,"fuelXLap"
               ,"rainLights"
               ,"flashingLights"
               ,"lightsStage"
               ,"exhaustTemperature"
               ,"wiperLV"
               ,"DriverStintTotalTimeLeft"
               ,"DriverStintTimeLeft"
               ,"rainTyres");
	}

	public int packetId = 0;
	public int status = 0;
	public int session = 0;
	public String currentTime;
	public String lastTime;
	public String bestTime;
	public String split;
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
	public float[] carCoordinates = new float[180];
	public int[] carID = new int[60];
	public int playerCarID = 0;
	public float penaltyTime = 0;
	public int flag = 0;
	public int penalty = 0;
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
	public float exhaustTemperature = 0;
	public int wiperLV = 0;
	public int DriverStintTotalTimeLeft = 0;
	public int DriverStintTimeLeft = 0;
	public int rainTyres = 0;
	
}
