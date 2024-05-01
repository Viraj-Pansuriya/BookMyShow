package com.example.BookMyShow.service;

import com.example.BookMyShow.dto.Reqdto.TicketEntryDto;
import com.example.BookMyShow.models.ShowSeat;
import com.example.BookMyShow.models.Shows;
import com.example.BookMyShow.models.Ticket;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.repo.ShowRepo;
import com.example.BookMyShow.repo.ShowSeatRepo;
import com.example.BookMyShow.repo.TicketRepo;
import com.example.BookMyShow.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServie {


    @Autowired
    private ShowRepo showRepo;
    @Autowired
    private ShowSeatRepo showSeatRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TicketRepo ticketRepo;
    public String generateTicket(TicketEntryDto ticketEntryDto) {
        // marked isAvailable of ticket to False , save ticket and added that into user ticket list.
        // only available ticket will be booked;

        int user_id = ticketEntryDto.getUser_id();
        int show_id = ticketEntryDto.getShow_id();
        List<String> requestedSeat = ticketEntryDto.getRequestSeats();

        Optional<Shows> temp_show = showRepo.findById(show_id);
        Shows show = temp_show.get();
        Optional<User> temp_user = userRepo.findById(user_id);
        User user = temp_user.get();
        List<ShowSeat> showSeatList = show.getShowSeatList();
        List<Ticket> user_ticket = user.getTicketList();

        boolean canBook = true;
        Ticket ticket = new Ticket();

        String booked_tickets ="";
        int booked = 0;
        int price = 0;
        for(ShowSeat showSeat : showSeatList){
            String seatNo = showSeat.getSeatNo();
            if(requestedSeat.contains(seatNo) && showSeat.isAvailable() == false){
                canBook = false;
                break;
            }
        }

        for(ShowSeat showSeat : showSeatList){
            String seatNo = showSeat.getSeatNo();
            if(requestedSeat.contains(seatNo)){
                showSeat.setAvailable(false);
                booked++;
                price += showSeat.getPrice();
                booked_tickets += seatNo;
                booked_tickets += "|";
            }
        }

        if(canBook == false) return "Reqested Seat is Not Available";
        booked_tickets = booked_tickets.substring(0 , booked_tickets.length()-1);
        ticket.setShow(show);
        ticket.setNumberofSeats(booked);
        ticket.setTotalprice(price);
        ticket.setUser(user);
        ticket.setBookedTickets(booked_tickets);
        ticket.setBookedAt(new Date());
        user_ticket.add(ticket);

        userRepo.save(user);

        String result = "Ticket has been booked";
        return result;
    }

    public String cancel(Integer ticket_id) {

        Optional<Ticket> temp_ticket = ticketRepo.findById(ticket_id);
        Ticket ticket = temp_ticket.get();
        String ticket_list = ticket.getBookedTickets();

        Shows shows = ticket.getShow();
        List < ShowSeat > showSeatList = shows.getShowSeatList();

        List<String> bookedSeat = List.of(ticket.getBookedTickets().split("\\|"));

        for(String st : bookedSeat) System.out.println(st);

        for(ShowSeat showSeat : showSeatList){
            if(bookedSeat.contains(showSeat.getSeatNo())){
                showSeat.setAvailable(true);
            }
        }
        ticket.getShow().getTicketList().remove(ticket);
        ticket.getUser().getTicketList().remove(ticket);
//        showRepo.save(shows);
//        userRepo.save(ticket.getUser());
        System.out.println(ticket.getUser().getTicketList().size());
        ticketRepo.delete(ticket);



        return "ticket deleted successfully";
    }
}
