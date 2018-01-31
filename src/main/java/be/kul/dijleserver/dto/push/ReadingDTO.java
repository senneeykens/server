package be.kul.dijleserver.dto.push;

import be.kul.dijleserver.domain.Reading;
import be.kul.dijleserver.dto.AbstractReadingDTO;
import be.kul.dijleserver.util.ReadingUtil;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReadingDTO extends AbstractReadingDTO {

    private String gpgga;

    public ReadingDTO() {
    }

    public ReadingDTO(long samplingTimestamp, double temperature, double turbidity, double disolvedOxygen, double flowRate) {
        super(samplingTimestamp, temperature, turbidity, disolvedOxygen, flowRate);
    }

    public String getGpgga() {
        return gpgga;
    }

    public void setGpgga(String gpgga) {
        this.gpgga = gpgga;
    }

    public Reading toReading() {
        final Reading reading = new Reading();
        reading.setSamplingTimestamp(ReadingUtil.of(this.getSamplingTimestamp()));
        reading.setTemperature(this.getTemperature());
        reading.setTurbidity(this.getTurbidity());
        reading.setDisolvedOxygen(this.getDisolvedOxygen());
        reading.setFlowRate(this.getFlowRate());

        if (StringUtils.hasText(this.getGpgga())) {
            final String[] split = this.getGpgga().split(",");
            reading.setLatitude(numberMagic (split[2]));
            reading.setLongtitude(numberMagic (split[4]));

        }
        return reading;
    }

    private double numberMagic ( String number ) {
        return BigDecimal.valueOf(
                Double.valueOf(number))
                    .divide(BigDecimal.valueOf(100), 6, RoundingMode.HALF_UP.ordinal()
        ).doubleValue();
    }

}