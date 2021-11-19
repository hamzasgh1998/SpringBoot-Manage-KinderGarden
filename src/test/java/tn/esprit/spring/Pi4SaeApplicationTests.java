package tn.esprit.spring;



import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.IOException;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Activities;
import tn.esprit.spring.entities.Cart;
import tn.esprit.spring.entities.Category_Products;
import tn.esprit.spring.entities.Comments;
import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.ItemList;
import tn.esprit.spring.entities.Kid;
import tn.esprit.spring.entities.KinderGarten;
import tn.esprit.spring.entities.KinderGartenAdmin;
import tn.esprit.spring.entities.Menu;
import tn.esprit.spring.entities.OfferProducts;
import tn.esprit.spring.entities.Posts;
import tn.esprit.spring.entities.Products;

import tn.esprit.spring.entities.enumerations.Days;
import tn.esprit.spring.entities.enumerations.Plat;

import tn.esprit.spring.entities.enumerations.Status;
import tn.esprit.spring.entities.enumerations.ValidePost;
import tn.esprit.spring.entities.enumerations.Subject;
import tn.esprit.spring.entities.enumerations.TypeActivity;
import tn.esprit.spring.entities.enumerations.TypeEvent;
import tn.esprit.spring.entities.enumerations.ValideComment;
import tn.esprit.spring.repository.ActivitiesRepository;
import tn.esprit.spring.service.ActivitiesService;
import tn.esprit.spring.service.CartService;
import tn.esprit.spring.service.CategoryService;
import tn.esprit.spring.service.CommentsService;
import tn.esprit.spring.service.EventsService;
import tn.esprit.spring.service.KidService;
import tn.esprit.spring.service.KinderGartenService;
import tn.esprit.spring.service.MenuService;
import tn.esprit.spring.service.OfferProductsService;
import tn.esprit.spring.service.PostsService;
import tn.esprit.spring.service.ProductsService;
import com.darkprograms.speech.translator.GoogleTranslate;
import com.vdurmont.emoji.*;

import javassist.Translator;
//hedhi khedmtiii
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Visitor;
import tn.esprit.spring.service.UserService;

import tn.esprit.spring.service.VisitorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Pi4SaeApplicationTests {
	
	@Autowired
	ActivitiesService us;

}
