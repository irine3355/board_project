package org.choongang.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties
public class FileProperties {

    private String path;
    private String url;
}
