package com.josam.clink.community;

import java.util.List;

import lombok.Data;

@Data
public class PopularPostList {
	private List<CommunityVO> popularPost;
	private List<CommunityVO> popularFreePost;
	private List<CommunityVO> popularInfoPost;
	private List<CommunityVO> popularAnnPost;
}
