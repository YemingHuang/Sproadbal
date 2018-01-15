package com.aft.client.thing;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Thing {

    private String name;
    private String description;

}
