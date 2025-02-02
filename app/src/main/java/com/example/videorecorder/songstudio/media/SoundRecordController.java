package com.example.videorecorder.songstudio.media;

public class SoundRecordController {

	/**
	 * 初始化OpenSL 录音器
	 * 
	 * @param minBufferSize
	 *            每个buffer的大小，注意是short数组中元素的个数
	 * @param sampleRate
	 *            采样率
	 * @param channels
	 *            声道数
	 * @param bitDepth
	 *            位深度
	 */
	public native boolean initMetaData(int minBufferSize, int sampleRate,
			int channels, int bitDepth);

	/**
	 * 初始化声音处理器
	 * @param packetBufferSize 
	 */
	public native boolean initAudioRecorderProcessor(int packetBufferSize);

	/**
	 * 销毁声音处理器
	 */
	public native void destroyAudioRecorderProcessor();

	/**
	 * 开始录音
	 */
	public native boolean start();

	/**
	 * 停止录音
	 */
	public native void stop();

	/************* 与打分相关的代码逻辑 *************/
	/**
	 * 初始化打分处理器
	 */
	public native void initScoring(int sampleRate, int channels, int bitsDepth, int scoringType);
	/**
	 * 因为pitch scoring是异步初始化基频处理器的 用到重采样，初始化可能需要3秒钟左右的时间，这里如果在这3秒钟内退出，这里设置初始化完毕接着销毁
	 */
	public native void setDestroyScoreProcessorFlag(boolean destroyScoreProcessorFlag);
	/**
	 * 获取打分渲染的数据
	 */
	public native void getRenderData(long currentTimeMills, float[] meta);
	/**
	 * 获取延迟（及第一次绘画的时间与最近的一个recordlevel的延时）
	 */
	public native int getLatency(long currentTimeMills);

	/** 获取清唱时候的音量大小 **/
	public native int getRecordVolume();
	/** 只有在清唱的时候才计算音量大小 **/
	public native void enableUnAccom();
}
