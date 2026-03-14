package at.spengergasse.fixtures;

import at.spengergasse.domain.ElectiveSubject;

import java.util.List;

public class ElectiveSubjectFixtures {

    public static ElectiveSubject BAP = new ElectiveSubject("BAP", 5);
    public static ElectiveSubject IOT = new ElectiveSubject("IOT", 5);
    public static ElectiveSubject SOS = new ElectiveSubject("SOS", 3);

    public static ElectiveSubject bap() {
        return BAP;
    }

    public static ElectiveSubject iot() {
        return IOT;
    }

    public static ElectiveSubject sos() {
        return SOS;
    }

    public static List<ElectiveSubject> subjects() {
        return List.of(BAP, IOT, SOS);
    }

}
