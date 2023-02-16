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
 * @date 2023年02月14日 9:00
 */
public class NrdpKafkaConsumer<K,V> implements Consumer<K,V> {
    @Override
    public Set<TopicPartition> assignment() {
        return null;
    }

    @Override
    public Set<String> subscription() {
        return null;
    }

    @Override
    public void subscribe(Collection<String> collection) {

    }

    @Override
    public void subscribe(Collection<String> collection, ConsumerRebalanceListener consumerRebalanceListener) {

    }

    @Override
    public void assign(Collection<TopicPartition> collection) {

    }

    @Override
    public void subscribe(Pattern pattern, ConsumerRebalanceListener consumerRebalanceListener) {

    }

    @Override
    public void subscribe(Pattern pattern) {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public ConsumerRecords<K, V> poll(long l) {
        return null;
    }

    @Override
    public ConsumerRecords<K, V> poll(Duration duration) {
        return null;
    }

    @Override
    public void commitSync() {

    }

    @Override
    public void commitSync(Duration duration) {

    }

    @Override
    public void commitSync(Map<TopicPartition, OffsetAndMetadata> map) {

    }

    @Override
    public void commitSync(Map<TopicPartition, OffsetAndMetadata> map, Duration duration) {

    }

    @Override
    public void commitAsync() {

    }

    @Override
    public void commitAsync(OffsetCommitCallback offsetCommitCallback) {

    }

    @Override
    public void commitAsync(Map<TopicPartition, OffsetAndMetadata> map, OffsetCommitCallback offsetCommitCallback) {

    }

    @Override
    public void seek(TopicPartition topicPartition, long l) {

    }

    @Override
    public void seek(TopicPartition topicPartition, OffsetAndMetadata offsetAndMetadata) {

    }

    @Override
    public void seekToBeginning(Collection<TopicPartition> collection) {

    }

    @Override
    public void seekToEnd(Collection<TopicPartition> collection) {

    }

    @Override
    public long position(TopicPartition topicPartition) {
        return 0;
    }

    @Override
    public long position(TopicPartition topicPartition, Duration duration) {
        return 0;
    }

    @Override
    public OffsetAndMetadata committed(TopicPartition topicPartition) {
        return null;
    }

    @Override
    public OffsetAndMetadata committed(TopicPartition topicPartition, Duration duration) {
        return null;
    }

    @Override
    public Map<TopicPartition, OffsetAndMetadata> committed(Set<TopicPartition> set) {
        return null;
    }

    @Override
    public Map<TopicPartition, OffsetAndMetadata> committed(Set<TopicPartition> set, Duration duration) {
        return null;
    }

    @Override
    public Map<MetricName, ? extends Metric> metrics() {
        return null;
    }

    @Override
    public List<PartitionInfo> partitionsFor(String s) {
        return null;
    }

    @Override
    public List<PartitionInfo> partitionsFor(String s, Duration duration) {
        return null;
    }

    @Override
    public Map<String, List<PartitionInfo>> listTopics() {
        return null;
    }

    @Override
    public Map<String, List<PartitionInfo>> listTopics(Duration duration) {
        return null;
    }

    @Override
    public Set<TopicPartition> paused() {
        return null;
    }

    @Override
    public void pause(Collection<TopicPartition> collection) {

    }

    @Override
    public void resume(Collection<TopicPartition> collection) {

    }

    @Override
    public Map<TopicPartition, OffsetAndTimestamp> offsetsForTimes(Map<TopicPartition, Long> map) {
        return null;
    }

    @Override
    public Map<TopicPartition, OffsetAndTimestamp> offsetsForTimes(Map<TopicPartition, Long> map, Duration duration) {
        return null;
    }

    @Override
    public Map<TopicPartition, Long> beginningOffsets(Collection<TopicPartition> collection) {
        return null;
    }

    @Override
    public Map<TopicPartition, Long> beginningOffsets(Collection<TopicPartition> collection, Duration duration) {
        return null;
    }

    @Override
    public Map<TopicPartition, Long> endOffsets(Collection<TopicPartition> collection) {
        return null;
    }

    @Override
    public Map<TopicPartition, Long> endOffsets(Collection<TopicPartition> collection, Duration duration) {
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
    public void close(long l, TimeUnit timeUnit) {

    }

    @Override
    public void close(Duration duration) {

    }

    @Override
    public void wakeup() {

    }
}
