package com.unifacisa.neomed.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode; // Importe JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.unifacisa.neomed.entity.Medico;
import com.unifacisa.neomed.entity.ProfissionalDeSaude;
import java.io.IOException;

public class ProfissionalDeSaudeDeserializer extends StdDeserializer<ProfissionalDeSaude> {

    public ProfissionalDeSaudeDeserializer() {
        this(null);
    }

    public ProfissionalDeSaudeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ProfissionalDeSaude deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException {
        JsonNode node = parser.getCodec().readTree(parser); // Use JsonNode diretamente
        String tipo = node.get("tipo").asText();

        if ("medico".equals(tipo)) {
            return parser.getCodec().treeToValue(node, Medico.class);
        }
        // Adicione outras condições para outras subclasses de ProfissionalDeSaude
        throw new IOException("Tipo de ProfissionalDeSaude desconhecido: " + tipo);
    }
}