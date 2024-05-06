package org.getarrayz.understandingjpa.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Builder
@Data
@ToString
public class Address implements Serializable {
    private String flatOrHouseNumber;
    private String streetName;
    private String areaName;
    private String cityName;
    private String districtName;
    private String stateName;
    private String pincode;
}
