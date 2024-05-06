package org.getarrayz.understandingjpa.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Interest implements Serializable {
    private String name;
}
