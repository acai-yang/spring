package com.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月14日 9:07
 */
public class NrdpKafkaConsumer2 implements Consumer {
    @Override
    public Set<TopicPartition> assignment() {
        return null;
    }

    @Override
    public Set<String> subscription() {
        return null;
    }

    @Override
    public void subscribe(Pattern pattern, ConsumerRebalanceListener callback) {

    }

    @Override
    public void subscribe(Pattern pattern) {

    }

    @Override
    public void unsubscribe() {

    }

    //todo
    @Override
    public ConsumerRecords poll(long timeout) {
        return null;
    }

    //todo
    @Override
    public ConsumerRecords poll(Duration timeout) {
        return null;
    }

    @Override
    public void commitSync() {

    }

    @Override
    public void commitSync(Duration timeout) {

    }

    @Override
    public void commitAsync() {

    }

    @Override
    public void commitAsync(OffsetCommitCallback callback) {

    }

    @Override
    public void seek(TopicPartition partition, long offset) {

    }

    @Override
    public void seek(TopicPartition partition, OffsetAndMetadata offsetAndMetadata) {

    }

    @Override
    public long position(TopicPartition partition) {
        return 0;
    }

    @Override
    public long position(TopicPartition partition, Duration timeout) {
        return 0;
    }

    @Override
    public OffsetAndMetadata committed(TopicPartition partition) {
        return null;
    }

    @Override
    public OffsetAndMetadata committed(TopicPartition partition, Duration timeout) {
        return null;
    }

    @Override
    public Map<MetricName, ? extends Metric> metrics() {
        return null;
    }

    @Override
    public List<PartitionInfo> partitionsFor(String topic) {
        return null;
    }

    @Override
    public List<PartitionInfo> partitionsFor(String topic, Duration timeout) {
        return null;
    }

    @Override
    public Map<String, List<PartitionInfo>> listTopics() {
        return null;
    }

    @Override
    public Map<String, List<PartitionInfo>> listTopics(Duration timeout) {
        return null;
    }

    @Override
    public Set<TopicPartition> paused() {
        return null;
    }

    @Override
    public ConsumerGroupMetadata groupMetadata() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void close(long timeout, TimeUnit unit) {

    }

    @Override
    public void close(Duration timeout) {

    }

    @Override
    public void wakeup() {

    }

    @Override
    public Map<TopicPartition, Long> endOffsets(Collection collection, Duration timeout) {
        return null;
    }

    @Override
    public Map<TopicPartition, Long> endOffsets(Collection collection) {
        return null;
    }

    @Override
    public Map<TopicPartition, Long> beginningOffsets(Collection collection, Duration timeout) {
        return null;
    }

    @Override
    public Map<TopicPartition, Long> beginningOffsets(Collection collection) {
        return null;
    }

    @Override
    public Map<TopicPartition, OffsetAndTimestamp> offsetsForTimes(Map timestampsToSearch, Duration timeout) {
        return null;
    }

    @Override
    public Map<TopicPartition, OffsetAndTimestamp> offsetsForTimes(Map timestampsToSearch) {
        return null;
    }

    @Override
    public void resume(Collection collection) {

    }

    @Override
    public void pause(Collection collection) {

    }

    @Override
    public Map<TopicPartition, OffsetAndMetadata> committed(Set set, Duration timeout) {
        return null;
    }

    @Override
    public Map<TopicPartition, OffsetAndMetadata> committed(Set set) {
        return null;
    }

    @Override
    public void seekToEnd(Collection collection) {

    }

    @Override
    public void seekToBeginning(Collection collection) {

    }

    //todo
    @Override
    public void commitAsync(Map offsets, OffsetCommitCallback callback) {

    }

    //todo
    @Override
    public void commitSync(Map offsets, Duration timeout) {

    }

    //todo
    @Override
    public void commitSync(Map offsets) {

    }

    //todo
    @Override
    public void assign(Collection collection) {

    }

    //todo
    @Override
    public void subscribe(Collection topics, ConsumerRebalanceListener callback) {

    }

    //todo
    @Override
    public void subscribe(Collection topics) {

    }
}
