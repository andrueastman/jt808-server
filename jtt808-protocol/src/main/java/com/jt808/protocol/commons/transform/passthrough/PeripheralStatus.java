package com.jt808.protocol.commons.transform.passthrough;

import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class PeripheralStatus {

    public static final int key = 0xF7;

    private List<Item> items;

    public PeripheralStatus() {
    }

    public PeripheralStatus(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(byte id, byte workState, int alarmStatus) {
        if (items == null)
            items = new ArrayList<>(4);
        items.add(new Item(id, workState, alarmStatus));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(150);
        sb.append("PeripheralStatus{");
        sb.append("items=").append(items);
        sb.append('}');
        return sb.toString();
    }

    public static class Item {
        /**
         * Peripheral ID：
         * 100.Advanced Driver Assistance Systems(ADAS)
         * 101.Driver Status Monitoring System(DSM)
         * 102.Tire Pressure Monitoring System(TPMS)
         * 103.Blind Spot Monitoring System(BSD)
         */
        private byte id;
        /** Working status: 1. Normal work 2. Standby status 3. Upgrade and maintenance 4. Device abnormal 16. Disconnect */
        private byte workState;
        /**
         * Alarm status：
         * Bitwise setting: 0. means no 1. means yes
         * [0]The camera is abnormal
         * [1]main memory exception
         * [2]Auxiliary memory exception
         * [3]Abnormal infrared fill light
         * [4]abnormal speaker
         * [5]battery abnormality
         * [6~9]reserved
         * [10]Communication module is abnormal
         * [ll]The positioning module is abnormal
         * [12~31]Reserved
         */
        private int alarmStatus;

        public Item() {
        }

        public Item(byte id, byte workState, int alarmStatus) {
            this.id = id;
            this.workState = workState;
            this.alarmStatus = alarmStatus;
        }

        public byte getId() {
            return id;
        }

        public void setId(byte id) {
            this.id = id;
        }

        public byte getWorkState() {
            return workState;
        }

        public void setWorkState(byte workState) {
            this.workState = workState;
        }

        public int getAlarmStatus() {
            return alarmStatus;
        }

        public void setAlarmStatus(int alarmStatus) {
            this.alarmStatus = alarmStatus;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(50);
            sb.append("{id=").append(id);
            sb.append(", workState=").append(workState);
            sb.append(", alarmStatus=").append(Integer.toBinaryString(alarmStatus));
            sb.append('}');
            return sb.toString();
        }
    }

    public static class Schema implements io.github.yezhihao.protostar.Schema<PeripheralStatus> {

        public static final Schema INSTANCE = new Schema();

        private Schema() {
        }

        @Override
        public PeripheralStatus readFrom(ByteBuf input) {
            byte total = input.readByte();
            List<Item> list = new ArrayList<>(total);
            while (input.isReadable()) {
                Item item = new Item();
                item.id = input.readByte();
                input.readByte();
                item.workState = input.readByte();
                item.alarmStatus = input.readInt();
                list.add(item);
            }
            return new PeripheralStatus(list);
        }

        @Override
        public void writeTo(ByteBuf output, PeripheralStatus message) {
            List<Item> items = message.getItems();
            output.writeByte(items.size());

            for (Item item : items) {
                output.writeByte(item.id);
                output.writeByte(5);

                output.writeByte(item.workState);
                output.writeInt(item.alarmStatus);
            }
        }
    }
}