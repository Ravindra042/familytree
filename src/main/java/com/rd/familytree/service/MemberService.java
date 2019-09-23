package com.rd.familytree.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rd.familytree.dao.MemberRepository;
import com.rd.familytree.domain.Member;
import com.rd.familytree.dto.MemberDTO;
import com.rd.familytree.utils.MemberMapper;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Transactional
	public Response count() {
		long count = memberRepository.count();
		return Response.ok(count).build();
	}

	@Transactional
	public Response read(String firstName, String lastName) {
		List<MemberDTO> memberDTOs = new ArrayList<MemberDTO>();
		Iterable<Member> members = null;
		if (null != firstName && null != lastName) {
			members = memberRepository.findByFirstAndLastName(firstName, lastName);
		} else if (null != lastName) {
			members = memberRepository.findByLastName(lastName);
		} else if (null != firstName) {
			members = memberRepository.findByFirstName(firstName);
		} else {
			members = memberRepository.findAll();
		}
		for (Member member : members) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTOs.add(MemberMapper.MapBasicMemberToDto(member, memberDTO));
		}
		return Response.ok(memberDTOs).build();
	}

	@Transactional
	public Response readById(long id) {
		Member member = memberRepository.findOne(id);
		MemberDTO memberDTO = new MemberDTO();
		MemberMapper.MapMemberToDto(member, memberDTO);
		return Response.ok(memberDTO).build();
	}

	@Transactional
	public Response create(MemberDTO memberDTO) {
		Member member = new Member();
		MemberMapper.MapDtoToMember(memberDTO, member);
		if (null != memberDTO.getFather() && null != memberDTO.getFather().getId()) {
			Member father = memberRepository.findOne(memberDTO.getFather().getId());
			member.setFather(father);
		}
		if (null != memberDTO.getMother() && null != memberDTO.getMother().getId()) {
			Member mother = memberRepository.findOne(memberDTO.getMother().getId());
			member.setMother(mother);
		}
		if (member.isMarried() && null != memberDTO.getLifePartner() && null != memberDTO.getLifePartner().getId()) {
			Member lifePartner = memberRepository.findOne(memberDTO.getLifePartner().getId());
			member.setLifePartner(lifePartner);
		}
		member = memberRepository.save(member);
		MemberMapper.MapMemberToDto(member, memberDTO);
		return Response.ok(memberDTO).build();
	}

	@Transactional
	public Response update(long id, MemberDTO memberDTO) {
		Member member = memberRepository.findOne(id);
		if (null == member) {
			return Response.noContent().build();
		}
		MemberMapper.MapDtoToMember(memberDTO, member);
		if (null != memberDTO.getFather() && null != memberDTO.getFather().getId()) {
			Member father = memberRepository.findOne(memberDTO.getFather().getId());
			member.setFather(father);
		}
		if (null != memberDTO.getMother() && null != memberDTO.getMother().getId()) {
			Member mother = memberRepository.findOne(memberDTO.getMother().getId());
			member.setMother(mother);
		}
		if (member.isMarried() && null != memberDTO.getLifePartner() && null != memberDTO.getLifePartner().getId()) {
			Member lifePartner = memberRepository.findOne(memberDTO.getLifePartner().getId());
			member.setLifePartner(lifePartner);
		}
		member = memberRepository.save(member);
		MemberMapper.MapMemberToDto(member, memberDTO);
		return Response.ok(memberDTO).build();
	}

}
