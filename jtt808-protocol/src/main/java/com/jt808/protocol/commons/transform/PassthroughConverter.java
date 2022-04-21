package com.jt808.protocol.commons.transform;

import io.github.yezhihao.protostar.PrepareLoadStrategy;
import io.github.yezhihao.protostar.schema.ArraySchema;
import io.github.yezhihao.protostar.schema.MapSchema;
import io.github.yezhihao.protostar.schema.NumberSchema;
import com.jt808.protocol.commons.transform.passthrough.PeripheralStatus;
import com.jt808.protocol.commons.transform.passthrough.PeripheralSystem;

public class PassthroughConverter extends MapSchema<Integer, Object> {

    public PassthroughConverter() {
        super(NumberSchema.BYTE_INT, 0);
    }

    @Override
    protected void addSchemas(PrepareLoadStrategy<Integer> schemaRegistry) {
        schemaRegistry
                .addSchema(0, ArraySchema.BYTES)
                .addSchema(PeripheralStatus.key, PeripheralStatus.Schema.INSTANCE)
                .addSchema(PeripheralSystem.key, PeripheralSystem.Schema.INSTANCE);
    }
}