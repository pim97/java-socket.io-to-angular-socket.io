package autoVoter.server;

import java.math.BigInteger;

public class TableModel {

	public TableModel(int i, String rowWebsite, int votedThisSession, int maxThreads, int stopAtVotes, int votingDelay,
			int proxyTimeout) {
		this.rowId = i;
		this.rowWebsite = rowWebsite;
		this.votedThisSession = votedThisSession;
		this.maxThreads = maxThreads;
		this.stopAtVotes = stopAtVotes;
		this.votingDelay = votingDelay;
		this.proxyTimeout = proxyTimeout;
		this.once = 0;
		this.captcha = 0;
		this.success = 0;
		this.shouldHaveSuccess = 0;
	}

	private BigInteger bigInt;

	private boolean stopVoting = false;

	private final int rowId;

	private int captcha = 0;

	private int success;

	private int succesRate;

	private int shouldHaveSuccess;

	private String rowWebsite;

	private int votedThisSession;

	private int maxThreads;

	private int votingDelay;

	private int proxyTimeout;

	private int once = 0;

	public int getShouldHaveSuccess() {
		return shouldHaveSuccess;
	}

	public void setShouldHaveSuccess(int shouldHaveSuccess) {
		this.shouldHaveSuccess = shouldHaveSuccess;
	}

	public int getSuccesRate() {
		return succesRate;
	}

	public void setSuccesRate(int succesRate) {
		this.succesRate = succesRate;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getCaptcha() {
		return captcha;
	}

	public void setCaptcha(int captcha) {
		this.captcha = captcha;
	}

	public int getOnce() {
		return once;
	}

	public void setOnce(int once) {
		this.once = once;
	}

	public int getVotingDelay() {
		return votingDelay;
	}

	public void setVotingDelay(int votingDelay) {
		this.votingDelay = votingDelay;
	}

	public BigInteger getBigInt() {
		return bigInt;
	}

	public void setBigInt(BigInteger bigInt) {
		this.bigInt = bigInt;
	}

	public int getStopAtVotes() {
		return stopAtVotes;
	}

	public void setStopAtVotes(int stopAtVotes) {
		this.stopAtVotes = stopAtVotes;
	}

	public int stopAtVotes;

	public int getVotedThisSession() {
		return votedThisSession;
	}

	public int getMaxThreads() {
		return maxThreads;
	}

	public void increaseByOne() {
	}

	public void setMaxThreads(int maxThreads) {
		this.maxThreads = maxThreads;
	}

	public void setRowWebsite(String rowWebsite) {
		this.rowWebsite = rowWebsite;
	}

	public int getProxyTimeout() {
		return proxyTimeout;
	}

	public void setProxyTimeout(int proxyTimeout) {
		this.proxyTimeout = proxyTimeout;
	}

	public int getRowId() {
		return rowId;
	}

	public String getRowWebsite() {
		return rowWebsite.replaceAll("\\s", "");
	}

	public boolean isStopVoting() {
		return stopVoting;
	}

	public void setStopVoting(boolean stopVoting) {
		this.stopVoting = stopVoting;
	}

}
