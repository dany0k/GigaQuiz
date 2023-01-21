package ru.vsu.cs.zmaev.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class QuestionBankSender extends ViewModel {
    private final MutableLiveData<List<ImageQuestion>> _topic = new MutableLiveData<>();
    LiveData<List<ImageQuestion>> topic = _topic;

    private final MutableLiveData<List<String>> _topics = new MutableLiveData<>();
    LiveData<List<String>> topics = _topics;

    private final MutableLiveData<Integer> _topicID = new MutableLiveData<>();
    LiveData<Integer> topicID = _topicID;

    public void setTopics(List<String> topics) {
        _topics.setValue(topics);
    }

    public List<String> getTopics() throws NullPointerException {
        return topics.getValue();
    }

    public void setTopicQuestions(List<ImageQuestion> topic) {
        _topic.setValue(topic);
    }

    public List<ImageQuestion> getTopicQuestions() throws NullPointerException {
        return topic.getValue();
    }

    public void setTopicID(Integer topicID) {
        _topicID.setValue(topicID);
    }

    public Integer getTopicID() throws NullPointerException {
        return topicID.getValue();
    }
}
