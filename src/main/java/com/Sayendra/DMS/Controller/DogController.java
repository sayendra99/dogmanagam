package com.Sayendra.DMS.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Sayendra.DMS.Models.Dog;
import com.Sayendra.DMS.Models.Trainer;
import com.Sayendra.DMS.repository.DogRepository;
import com.Sayendra.DMS.repository.TrainerRepository;

@Controller
public class DogController 
{ModelAndView mv =new ModelAndView();
@Autowired
DogRepository  dogRepo;
//	@RequestMapping("dogHome")
//	public String home() {
//		
//	return "home";}
//
//	
@Autowired
TrainerRepository trainerRepo;
		@RequestMapping("dogHome")
	public ModelAndView home()
	{
		mv.setViewName("Home");
		return mv;
	}
		@RequestMapping("add")
		public ModelAndView add()

		{
			mv.setViewName("addNewDog.html");
			return mv;
		}
		@RequestMapping("addNewDog")
		public ModelAndView addNewDog(Dog dog)

		{
			dogRepo.save(dog);
			mv.setViewName("home");
			return mv;
		}
		
		
		@RequestMapping("viewModifyDelete")
		public ModelAndView ViewDogs()

		{
			
			mv.setViewName("ViewDogs");
Iterable<Dog>		dogList=dogRepo.findAll();
mv.addObject("dogs",dogList);
		return mv;
		}
		
		
		
		@RequestMapping("editDog")
		public ModelAndView editDog(Dog dog)

		{
			
			
dogRepo.save(dog);
mv.setViewName("editDog");
		return mv;
		}
		
		
	@RequestMapping("deleteDog")
		public ModelAndView deleteDog( Dog dog )
		{
//			Optional <Dog> t=dogRepo.findById(dog.getId());
//			
//			if(t.isPresent())
//			{
//				dogRepo.delete(dog);
//			}
//			return home();			
//		}
//		
////
////		List <Dog> dogsFound=dogRepo.findByName(dog.getName());
////		for(Dog d: dogsFound) {
//			dogRepo.delete(d);
////		}
////		return home();
////		}
		
		Dog d= dogRepo.findById(dog.getId()).orElse(new Dog());
		dogRepo.delete(d);
		return home();
		
}

	@RequestMapping("search")
	public ModelAndView searchById( int id )
	{
		Dog dogFound =dogRepo.findById(id).orElse(new Dog());
		mv.addObject(dogFound);
		mv.setViewName("searchResults");
		return mv;
		
	}
	@RequestMapping( "addTrainer")
	public ModelAndView addTrainer()
	{
		mv.setViewName("addNewTrainer");
		return mv;
		
	}
	@RequestMapping( "trainerAdded")
	public ModelAndView addNewTrainer(Trainer trainer)
	{
		trainerRepo.save(trainer);
		mv.setViewName("home");
		
		return mv;
		
		
	}
	
	
}
