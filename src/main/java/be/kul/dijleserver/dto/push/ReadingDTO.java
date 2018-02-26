package be.kul.dijleserver.dto.push;

import be.kul.dijleserver.domain.Reading;
import be.kul.dijleserver.dto.AbstractReadingDTO;
import be.kul.dijleserver.util.ReadingUtil;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReadingDTO extends AbstractReadingDTO {

    private String gps;

    public ReadingDTO() {
    }

    public ReadingDTO(long samplingTimestamp, double temperature, double turbidity, double disolvedOxygen, double flowRate) {
        super(samplingTimestamp, temperature, turbidity, disolvedOxygen, flowRate);
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gpgga) {
        this.gps = gpgga;
    }

    public Reading toReading() {
        final Reading reading = new Reading();
        reading.setSamplingTimestamp(ReadingUtil.of(this.getSamplingTimestamp()));
        reading.setTemperature(this.getTemperature());
        reading.setTurbidity(this.getTurbidity());
        reading.setDisolvedOxygen(this.getDisolvedOxygen());
        reading.setFlowRate(this.getFlowRate());


        // see https://www.experts-exchange.com/questions/22112629/Converting-NMEA-sentence-Latitude-and-Longitude-to-Decimal-Degrees.html
        // $GPRMC,204432.00,A,5111.59428,N,00432.82947,E,4.773,,250218,,,D*7E
        if (StringUtils.hasText(this.getGps())) {
            final String[] split = this.getGps().split(",");

            String ddd = split[3].substring(0, 2);
            String mmm = split[3].substring(2);

            reading.setLatitude(numberMagic(ddd, mmm));

            ddd = split[5].substring(0, 3);
            mmm = split[5].substring(3);

            reading.setLongtitude(numberMagic(ddd, mmm));

        }
        return reading;
    }

    private double numberMagic(String ddd, String mmm) {
        return Double.valueOf(ddd) +
                BigDecimal.valueOf(
                        Double.valueOf(mmm)).divide(BigDecimal.valueOf(60), 5, RoundingMode.HALF_UP.ordinal()
                ).doubleValue();
    }

}