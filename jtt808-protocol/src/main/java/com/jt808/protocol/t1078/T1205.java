package com.jt808.protocol.t1078;

import io.github.yezhihao.netmc.core.model.Response;
import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT1078;

import java.time.LocalDateTime;
import java.util.List;

@Message(JT1078.ListOfAudioAndVideoResourcesUploadedByTheTerminal)
public class T1205 extends JTMessage implements Response {

    @Field(length = 2, desc = "Reply serial number")
    private int responseSerialNo;
    @Field(totalUnit = 4, desc = "Audio and video resource list")
    private List<Item> items;

    public int getResponseSerialNo() {
        return responseSerialNo;
    }

    public void setResponseSerialNo(int responseSerialNo) {
        this.responseSerialNo = responseSerialNo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item {

        @Field(length = 1, desc = "logical channel number")
        private int channelNo;
        @Field(length = 6, charset = "BCD", desc = "Starting time")
        private LocalDateTime startTime;
        @Field(length = 6, charset = "BCD", desc = "end time")
        private LocalDateTime endTime;
        @Field(length = 4, desc = "Alarm flag 0~31 (refer to the 808 protocol document for the definition of alarm flag bits)")
        private int warnBit1;
        @Field(length = 4, desc = "Alarm signs 32~63")
        private int warnBit2;
        @Field(length = 1, desc = "Audio and video resource types")
        private int mediaType;
        @Field(length = 1, desc = "stream type")
        private int streamType = 1;
        @Field(length = 1, desc = "memory type")
        private int storageType;
        @Field(length = 4, desc = "file size")
        private long size;

        public Item() {
        }

        public Item(int channelNo, LocalDateTime startTime, LocalDateTime endTime, int warnBit1, int warnBit2, int mediaType, int streamType, int storageType, long size) {
            this.channelNo = channelNo;
            this.startTime = startTime;
            this.endTime = endTime;
            this.warnBit1 = warnBit1;
            this.warnBit2 = warnBit2;
            this.mediaType = mediaType;
            this.streamType = streamType;
            this.storageType = storageType;
            this.size = size;
        }

        public int getChannelNo() {
            return channelNo;
        }

        public void setChannelNo(int channelNo) {
            this.channelNo = channelNo;
        }

        public LocalDateTime getStartTime() {
            return startTime;
        }

        public void setStartTime(LocalDateTime startTime) {
            this.startTime = startTime;
        }

        public LocalDateTime getEndTime() {
            return endTime;
        }

        public void setEndTime(LocalDateTime endTime) {
            this.endTime = endTime;
        }

        public int getWarnBit1() {
            return warnBit1;
        }

        public void setWarnBit1(int warnBit1) {
            this.warnBit1 = warnBit1;
        }

        public int getWarnBit2() {
            return warnBit2;
        }

        public void setWarnBit2(int warnBit2) {
            this.warnBit2 = warnBit2;
        }

        public int getMediaType() {
            return mediaType;
        }

        public void setMediaType(int mediaType) {
            this.mediaType = mediaType;
        }

        public int getStreamType() {
            return streamType;
        }

        public void setStreamType(int streamType) {
            this.streamType = streamType;
        }

        public int getStorageType() {
            return storageType;
        }

        public void setStorageType(int storageType) {
            this.storageType = storageType;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(128);
            sb.append('{');
            sb.append("channelNo=").append(channelNo);
            sb.append(",startTime=").append(startTime);
            sb.append(",endTime=").append(endTime);
            sb.append(",warnBit1=").append(Integer.toBinaryString(warnBit1));
            sb.append(",warnBit2=").append(Integer.toBinaryString(warnBit2));
            sb.append(",mediaType=").append(mediaType);
            sb.append(",streamType=").append(streamType);
            sb.append(",storageType=").append(storageType);
            sb.append(",size=").append(size);
            sb.append('}');
            return sb.toString();
        }
    }
}
