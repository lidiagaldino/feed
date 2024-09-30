package br.com.lidiagaldino.feed.controller.params;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;

public class LanguageQueryParam {
    @DefaultValue("pt")
    @QueryParam("targetLang")
    private String targetLang;

    public String getTargetLang() {
        return targetLang;
    }

    public void setTargetLang(String targetLang) {
        this.targetLang = targetLang;
    }
}
