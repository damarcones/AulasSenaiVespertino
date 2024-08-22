package com.autenticacao.appautentic.DTOs;

import java.util.List;

import com.autenticacao.appautentic.Model.RuleModel;

public record RecoveryUsuarioDTO(
    Long id,
    String email,
    List<RuleModel> rules
) {

}
