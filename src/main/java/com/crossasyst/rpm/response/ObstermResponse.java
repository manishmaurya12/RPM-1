package com.crossasyst.rpm.response;

import com.crossasyst.rpm.model.Obsterm;
import lombok.Data;

@Data
public class ObstermResponse extends Obsterm {
    private Long obstermId;
}
