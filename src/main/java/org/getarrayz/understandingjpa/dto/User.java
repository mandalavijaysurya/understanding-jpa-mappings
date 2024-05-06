package org.getarrayz.understandingjpa.dto;

import lombok.*;
import org.getarrayz.understandingjpa.dto.enumeration.Gender;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class User implements Serializable {
    private String name;
    private String age;
    private Gender gender;
    private List<Address> address;
    private Set<Interest> interests;
}
