package com.rd.familytree.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.rd.familytree.domain.Member;
import com.rd.familytree.dto.MemberDTO;

public class MemberMapper {

	public static MemberDTO MapMemberToDto(Member member, MemberDTO memberDTO) {
		MapBasicMemberToDto(member, memberDTO);
		if (null != member.getFather()) {
			MemberDTO fatherDto = new MemberDTO();
			MapBasicMemberToDto(member.getFather(), fatherDto);
			memberDTO.setFather(fatherDto);
		}
		if (null != member.getMother()) {
			MemberDTO motherDto = new MemberDTO();
			MapBasicMemberToDto(member.getMother(), motherDto);
			memberDTO.setMother(motherDto);
		}
		if (member.isMarried() && null != member.getLifePartner()) {
			MemberDTO lifePartnerDto = new MemberDTO();
			MapBasicMemberToDto(member.getLifePartner(), lifePartnerDto);
			memberDTO.setLifePartner(lifePartnerDto);
		}
		return memberDTO;
	}

	public static MemberDTO MapBasicMemberToDto(Member member, MemberDTO memberDTO) {
		if (null == member)
			return memberDTO;
		memberDTO.setId(member.getId());
		memberDTO.setFirstName(member.getFirstName());
		memberDTO.setLastName(member.getLastName());
		memberDTO.setNickName(member.getNickName());
		memberDTO.setAbout(member.getAbout());
		memberDTO.setAlive(member.isAlive());
		if (null != member.getDateOfBirth())
			memberDTO.setDateOfBirth(member.getDateOfBirth().toString());
		memberDTO.setGender(member.getGender());
		memberDTO.setMarried(member.isMarried());
		if (member.isMarried() && null != member.getWeddingAnniversaryDate())
			memberDTO.setWeddingAnniversaryDate(member.getWeddingAnniversaryDate().toString());
		memberDTO.setProfileCompleted(member.isProfileCompleted());
		memberDTO.setActive(member.isActive());
		if (!member.isAlive() && null != member.getDeathDate())
			memberDTO.setDeathDate(member.getDeathDate().toString());
		return memberDTO;
	}

	public static void MapDtoToMember(MemberDTO memberDTO, Member member) {
		member.setFirstName(memberDTO.getFirstName());
		member.setLastName(memberDTO.getLastName());
		member.setNickName(memberDTO.getNickName());
		member.setAbout(memberDTO.getAbout());
		member.setAlive(memberDTO.isAlive());
		if (null != memberDTO.getDateOfBirth())
			member.setDateOfBirth(ConvertStringDate(memberDTO.getDateOfBirth()));
		member.setGender(memberDTO.getGender());
		member.setMarried(memberDTO.isMarried());
		if (member.isMarried() && null != memberDTO.getWeddingAnniversaryDate())
			member.setWeddingAnniversaryDate(ConvertStringDate(memberDTO.getWeddingAnniversaryDate()));
		member.setProfileCompleted(false);
		member.setActive(true);
		if (!member.isAlive() && null != memberDTO.getDeathDate()) {
			member.setDeathDate(ConvertStringDate(memberDTO.getDeathDate()));
		}
	}

	private static Date ConvertStringDate(String dateInString) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:SS.s").parse(dateInString);
		} catch (ParseException e) {
			System.out.println("failed to convert date");
			e.printStackTrace();
		}
		return null;
	}

}
