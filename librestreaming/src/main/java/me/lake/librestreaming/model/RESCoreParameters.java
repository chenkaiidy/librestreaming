package me.lake.librestreaming.model;

import java.lang.reflect.Field;

import me.lake.librestreaming.tools.LogTools;

/**
 * Created by lake on 16-3-16.
 */
public class RESCoreParameters {
    public boolean done;
    public boolean printDetailMsg;
    public String rtmpAddr;
    public int videoWidth;
    public int videoHeight;
    public int previewColorFormat;
    public int previewBufferSize;
    public int mediacodecAVCColorFormat;
    public int mediacdoecAVCBitRate;
    public int videoBufferQueueNum;
    public int audioBufferQueueNum;
    public int audioRecoderFormat;
    public int audioRecoderSampleRate;
    public int audioRecoderChannelConfig;
    public int audioRecoderSliceSize;
    public int audioRecoderSource;
    public int audioRecoderBufferSize;
    public int previewMaxFps;
    public int previewMinFps;
    public int mediacodecAVCFrameRate;
    public int mediacodecAVCIFrameInterval;
    public int mediacodecAVCProfile;
    public int mediacodecAVClevel;

    public int mediacodecAACProfile;
    public int mediacodecAACSampleRate;
    public int mediacodecAACChannelCount;
    public int mediacodecAACBitRate;
    public int mediacodecAACMaxInputSize;

    //sender
    public int senderQueueLength;

    public RESCoreParameters() {
        done = false;
        printDetailMsg = false;
        videoWidth = -1;
        videoHeight = -1;
        previewColorFormat = -1;
        mediacodecAVCColorFormat = -1;
        mediacdoecAVCBitRate = -1;
        videoBufferQueueNum = -1;
        audioBufferQueueNum = -1;
        mediacodecAVCFrameRate = -1;
        mediacodecAVCIFrameInterval = -1;
        mediacodecAVCProfile = -1;
        mediacodecAVClevel = -1;
        mediacodecAACProfile = -1;
        mediacodecAACSampleRate = -1;
        mediacodecAACChannelCount = -1;
        mediacodecAACBitRate = -1;
        mediacodecAACMaxInputSize = -1;
    }

    public void dump() {
        LogTools.e(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                sb.append(field.getName());
                sb.append('=');
                sb.append(field.get(this));
                sb.append(';');
            } catch (IllegalAccessException e) {
            }
        }
        return sb.toString();
    }
}