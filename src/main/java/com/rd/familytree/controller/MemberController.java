package com.rd.familytree.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rd.familytree.dto.MemberDTO;
import com.rd.familytree.service.MemberService;

@Controller
@Path("/member")
@Produces(MediaType.APPLICATION_JSON)
public class MemberController {

	private static Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService memberService;

	@GET
	@Path("/count")
	public Response count() {
		logger.info("reading count");
		return memberService.count();
	}

	@GET
	public Response read(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName) {
		logger.info("reading member by names");
		return memberService.read(firstName, lastName);
	}

	@GET
	@Path("/{id}")
	public Response readById(@PathParam("id") long id) {
		logger.info("reading member by id {}", id);
		return memberService.readById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(MemberDTO memberDTO) {
		logger.info("creating member");
		return memberService.create(memberDTO);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") long id, MemberDTO memberDTO) {
		logger.info("updating member id {}", id);
		return memberService.update(id, memberDTO);
	}

}
