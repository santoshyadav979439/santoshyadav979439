package com.santosh.entities;

import com.santosh.partner.Shareable;

public class WebLink extends Bookmark implements Shareable {
	private String url;
	private String host;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return "WebLink [url=" + url + ", host=" + host + "]";
	}

	@Override
	public boolean isKidfriendlyEligible() {
		if (url.contains("porn") || getTitle().contains("porn") || host.contains("adult"))
			return false;
		if ((url.contains("adult") && !host.contains("adult")) || getTitle().contains("adult"))
			return true;
		return true;

	}

	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
		builder.append("<type>").append("weblink").append("</type>");
		builder.append("<url>").append(url).append("</url>");
		builder.append("<host>").append(host).append("</host>");
		builder.append("</item>");
		return builder.toString();

	}
}
