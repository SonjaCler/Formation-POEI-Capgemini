package com.aplose.smooss.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.aplose.smooss.factory.FactoryModule;
import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.Module;
import com.aplose.smooss.model.PicturesModule;
import com.aplose.smooss.model.Module.TypeModule;
import com.aplose.smooss.model.User;

public class EventService {

	private static EventService INSTANCE;
	private TypedQuery<Event> queryFindEventByUser;
	private static FactoryModule fm = new FactoryModule();

	private EventService() {}

	public static EventService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EventService();
		}

		return INSTANCE;
	}

	public void create(Event evt) {
		JPASingleton.getInstance().getEntityManager().getTransaction().begin();
		JPASingleton.getInstance().getEntityManager().persist(evt);
		JPASingleton.getInstance().getEntityManager().getTransaction().commit();
	}

	public Event read(long id) {
		Event evt = JPASingleton.getInstance().getEntityManager().find(Event.class, id);
		return evt;
	}
	
	public Event modify(Event evt) {
		if (!JPASingleton.getInstance().getEntityManager().getTransaction().isActive()) {
			JPASingleton.getInstance().getEntityManager().getTransaction().begin();
		}
		JPASingleton.getInstance().getEntityManager().merge(evt);
		JPASingleton.getInstance().getEntityManager().getTransaction().commit();
		return evt;
	}

	public List<Event> findEventsByUser(User user) {
		if (queryFindEventByUser == null) {
			EntityManager em = JPASingleton.getInstance().getEntityManager();
			queryFindEventByUser = em.createQuery("SELECT e FROM Event e WHERE admin = :user ", Event.class);
		}
		queryFindEventByUser.setParameter("user", user);
		List<Event> result = null;
		try {
			result = queryFindEventByUser.getResultList();
		}catch (NoResultException nre) {
			result = new ArrayList<Event>();
		}
		return result;
	}
	
	public Module findModuleByEvent(Event e, TypeModule t) {
		
		Module module = null;
		for(Module m : e.getModules()) {
			if(m.getType() == t) {
				module = m;
			}
		}
		return module;
	}

	// Flavien && Rachid : START: ajout d'un module à un event
	public void addModuleByEvent(Event evt, TypeModule tm) {
		Module m = fm.creerModule(tm);
		evt.getModules().add(m);
		JPASingleton.getInstance().getEntityManager().getTransaction().begin();
		JPASingleton.getInstance().getEntityManager().persist(m);
		JPASingleton.getInstance().getEntityManager().merge(evt);
		JPASingleton.getInstance().getEntityManager().getTransaction().commit();
	}
	// Flavien && Rachid : END
	
	public void delete(Event evt) {
		JPASingleton.getInstance().getEntityManager().getTransaction().begin();
		JPASingleton.getInstance().getEntityManager().remove(evt);
		JPASingleton.getInstance().getEntityManager().getTransaction().commit();
	}

	// Rachid :START : Ajout(partage) d'un user à un event : A COMITER SOUS VERIF
	public void addUserByEvent(Event evt, User user) {
		if (!evt.getParticipants().contains(user)){
			evt.getParticipants().add(user);
			JPASingleton.getInstance().getEntityManager().getTransaction().begin();
			JPASingleton.getInstance().getEntityManager().merge(evt);
			JPASingleton.getInstance().getEntityManager().getTransaction().commit();
		}
	}
	// Rachid :END
}